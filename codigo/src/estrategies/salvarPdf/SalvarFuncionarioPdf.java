package estrategies.salvarPdf;

import utilitarios.CriarPdf;

public class SalvarFuncionarioPdf implements EstrategyPdf{
    @Override
    public void imprimirPdf() {
        CriarPdf.pdf("relatorioFuncionario",new float[]{3,3,3,3,3,3,3});

    }
}
