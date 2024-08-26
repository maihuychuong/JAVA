package techmasterstudent;

public class ITStudent extends TechMasterStudent{
    private double java;
    private double html;
    private double css;

    public ITStudent(double java, double html, double css) {
        this.java = java;
        this.html = html;
        this.css = css;
    }

    @Override
    public double getScore() {
        return (2*java+html+css)/4;
    }

    public double getJava() {
        return java;
    }

    public void setJava(double java) {
        this.java = java;
    }

    public double getHtml() {
        return html;
    }

    public void setHtml(double html) {
        this.html = html;
    }

    public double getCss() {
        return css;
    }

    public void setCss(double css) {
        this.css = css;
    }
}
