public class ScannerMock extends ScannerAdapter {
    String entered;

    public ScannerMock(String entered) {
        this.entered = entered;
    }

    public String next() {
        return entered;
    }
}
