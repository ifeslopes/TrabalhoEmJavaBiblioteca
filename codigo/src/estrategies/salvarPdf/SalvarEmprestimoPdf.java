package estrategies.salvarPdf;

import utilitarios.CriarPdf;

public class SalvarEmprestimoPdf implements EstrategyPdf{
    @Override
    public void imprimirPdf() {
        CriarPdf.pdf("relatorioEmprestimo",new float[]{3,3,3,3,5,3});

    }
}
