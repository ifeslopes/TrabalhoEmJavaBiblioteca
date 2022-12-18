package utilitarios;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CriarPdf {

    public static void pdf(String aruivo, float[] colunas) {

        try {
            File diretorioPdf = new File("codigo/src/utilitarios/Pdf");
            if(!diretorioPdf.exists()){
                diretorioPdf.mkdir();
            }

            PdfWriter writer = new PdfWriter("codigo/src/utilitarios/Pdf/"+aruivo+".pdf");
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf, PageSize.A4.rotate());
            File diretorio = new File("codigo/src/utilitarios/Relatorio");
            File arquivo = new File(diretorio, aruivo+".csv");
            String titulo = aruivo.substring(9);


            Paragraph p = new Paragraph("Trabalho Final LP2").setTextAlignment(TextAlignment.CENTER).setFont(PdfFontFactory
                    .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(17);
            document.add(p);

            p = new Paragraph("Gerenciamento de Biblioteca")
                    .setTextAlignment(TextAlignment.CENTER).setFont(PdfFontFactory
                    .createFont(StandardFonts.HELVETICA_BOLDOBLIQUE)).setFontSize(17).setBorderBottom(new SolidBorder(1f));
            document.add(p);

             p = new Paragraph()
                    .setTextAlignment(TextAlignment.CENTER).setFont(PdfFontFactory
                            .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14);
             p = new Paragraph("Nome Do Funcionário: "+ Login.getNomeFuncionarioLogado())
                    .setTextAlignment(TextAlignment.LEFT).setFont(PdfFontFactory
                            .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14);
            document.add(p);
             p = new Paragraph("Matrícula: "+Login.getMatriculaFuncionarioLogado())
                    .setTextAlignment(TextAlignment.LEFT).setFont(PdfFontFactory
                            .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14);
            document.add(p);

             p = new Paragraph("Data: "+CalculadoraDeData.getDataHoje())
                    .setTextAlignment(TextAlignment.LEFT).setFont(PdfFontFactory
                            .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14).setBorderBottom(new SolidBorder(1f));
            document.add(p);
            p = new Paragraph("Relaório de "+titulo)
                    .setTextAlignment(TextAlignment.CENTER).setFont(PdfFontFactory
                            .createFont(StandardFonts.HELVETICA_BOLD)).setFontSize(14);
            document.add(p);


            document.setMargins(20, 20, 20, 20);
            PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
            PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
            Table table = new Table(colunas);
            table.setWidth(UnitValue.createPercentValue(100));
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String line = br.readLine();
            process(table, line, bold, true);
            while ((line = br.readLine()) != null) {
                process(table, line, font, false);
            }
            br.close();
            document.add(table);
            document.close();
        } catch (IOException e) {
            System.out.println("ERRO!! " + e.getMessage());
        }
    }
        public static void process(Table table, String line, PdfFont font, boolean isHeader) {


                StringTokenizer tokenizer = new StringTokenizer(line, ";");

                while (tokenizer.hasMoreTokens()) {
                    if (isHeader) {
                        table.addHeaderCell(
                                new Cell().add(
                                        new Paragraph(tokenizer.nextToken()).setFont(font)));
                    } else {
                        table.addCell(
                                new Cell().add(
                                        new Paragraph(tokenizer.nextToken()).setFont(font)));
                    }
                }

        }


}
