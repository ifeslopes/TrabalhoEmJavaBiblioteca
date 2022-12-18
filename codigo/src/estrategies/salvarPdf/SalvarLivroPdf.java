package estrategies.salvarPdf;

import utilitarios.CriarPdf;

public class SalvarLivroPdf implements EstrategyPdf{
    @Override
    public void imprimirPdf() {
        CriarPdf.pdf("relatorioLivros",new float[]{3,3,3,3,3,3,3});

    }
}
