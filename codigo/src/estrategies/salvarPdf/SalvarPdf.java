package estrategies.salvarPdf;

public class SalvarPdf {
    EstrategyPdf salvarPdf;
    public SalvarPdf() {
    }


    public void setSalvarPdf(EstrategyPdf salvarPdf) {
        this.salvarPdf = salvarPdf;
    }
    public void getSalvarPdf() {
         salvarPdf.imprimirPdf();
    }
}
