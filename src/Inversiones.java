public class Inversiones {
    private float inversion1;
    private float inversion2;
    private float inversion3;

    public void setInversion1(float inversion1) {this.inversion1 = inversion1;}
    public void setInversion2(float inversion2) {this.inversion2 = inversion2;}
    public void setInversion3(float inversion3) {this.inversion3 = inversion3;}
    public float getInversion1() {
        return inversion1;
    }
    public float getInversion2() {
        return inversion2;
    }
    public float getInversion3() {
        return inversion3;
    }
    public void aumentarInversion1(){
        inversion1 += 1;
    }
    public void aumentarInversion2(){
        inversion2 += 1.5;
    }
    public void aumentarInversion3(){
        inversion3 += 0.5;
    }
}
