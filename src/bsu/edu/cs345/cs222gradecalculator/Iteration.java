package bsu.edu.cs345.cs222gradecalculator;

public class Iteration {
    private double codeQuality = 0;
    private double processQuality = 0;
    private double presentationQuality = 0;
    private double reflectionQuality = 0;
    private int maxPointsForIteration;


    public void setCodeQuality(int gradeRecived){
        codeQuality = (.40*this.maxPointsForIteration)*((gradeRecived*1.0)/3);
    }
    public void setProcessQuality(int gradeRecived){
        processQuality = (.40*this.maxPointsForIteration) * ((gradeRecived*1.0)/3);
    }
    public void setPresentationQuality(int gradeRecived){
        presentationQuality = (.10*this.maxPointsForIteration) * ((gradeRecived*1.0)/3);
    }
    public void setReflectionQuality(int gradeRecived){
        reflectionQuality = (.10*(this.maxPointsForIteration)) * ((gradeRecived*1.0)/3);
    }
    public double calculateIterationGrade(){
        return (codeQuality + processQuality + presentationQuality + reflectionQuality);
    }
    public Iteration(int maxPoints){
        maxPointsForIteration = maxPoints;
    }



}
