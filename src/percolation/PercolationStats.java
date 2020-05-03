package percolation;
import java.util.*;

public class PercolationStats {
    private double[] pthresholds;
    StdStats stat;
    int len;
    int T;
    public PercolationStats(int n,int trials) {
        len = n;
        T=trials;
        pthresholds = new double[trials];
        if(n<=0 || trials<=0) throw  new IllegalArgumentException();

        int max = n;
        int min =1;

        for(int m=0;m<trials;m++) {
            Percolation grid =  new Percolation(n);
            for(int i =0;i<len*len;i++) {
                int row = (int) (Math.random() * (max-min+1)+min);
                int column = (int) (Math.random() * (max-min+1)+min);
                if(row <1 || row>len || column<1 || column >len){
                    System.out.printf("%d %d", row, column);
                    throw new IndexOutOfBoundsException();
                }

                grid.open(row,column);
           /*     grid.displayUF();*/
                if(grid.percolates()){
                    /*System.out.printf("%d later" , i);*/
                    pthresholds[m] = (double)(i+1)/(len*len);
                    break;
                }
            }
        }
    }

    public double mean() {
      return stat.mean(pthresholds);
    }
    public double stddev() {
        return stat.stddev(pthresholds);
    }

    public double confidenceLo() {
       double res=  (double)(mean()-((1.96)*stddev()/Math.sqrt(T)));
       return res;
    }

    public double confidenceHi() {
        double res =  (double)(mean()+((1.96)*stddev()/Math.sqrt(T)));
        return res;
    }

    public void displayP() {
        for(double i: pthresholds) {
            System.out.print(i);
        }
        System.out.print(pthresholds.length);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int trials = input.nextInt();
        PercolationStats client = new PercolationStats(n,trials);
        System.out.printf("mean:  %f \n",client.mean());
        System.out.printf("stddev: %f \n",client.stddev());
        System.out.printf("95%% confidence interval: %f  %f  \n",client.confidenceLo(),client.confidenceHi());
         /*client.displayP();*/
    }
}
