import java.io.PrintWriter;
import java.math.*;
import java.util.Scanner;

/**
 * Created by milson on 20.10.16.
 */
public class Solution {
    public long Module(long FirstNumber, long SecondNumber) {
        if(FirstNumber > 0)
            return FirstNumber % SecondNumber;
        while(FirstNumber < 0)
            FirstNumber +=SecondNumber;
        return FirstNumber;
    }
    public byte Length(long Number){
       if(Number < 0)
           System.out.println("Negative number");
        if(Number == 0)
            return 0;
        long Number_ = 1;
        byte Length_ = 1;
        while ((Number_ <<= 1) <= Number)
            ++Length_;
        return Length_;
    }
    public boolean[] getBinary(long Number){
        byte Length_ = Length(Number);
        boolean[] Figure_= new boolean[Length_];
        long Number_ = 1;
        for (int i = Length_ - 1; i >= 0; --i){
            if((Number & Number_) != 0)
                Figure_[i] = true;
            Number_ <<= 1;
        }
        return Figure_;
    }

    public void ViewBinary(boolean[] NumberBinary){
        for (boolean b: NumberBinary) {
            if(b)
                System.out.print(1);
            else
                System.out.print(0);
        }
    }

    public void ViewBinary (long Number){
        ViewBinary(getBinary(Number));
    }
//возведение числа в степень по модулю
    public long PowerByModule(long Number, long Power, long Module){
        if(Power < 0)
            return -1;
        if(Module < 0)
            return -1;
        int Length_;
        boolean[] Figure_ = getBinary((long) Power);
        long[] Power_ = new long[Length_ = Figure_.length];
        long Result_ = 1;
        Power_[Length_ - 1] = Number % Module;
        for(int i = Length_ - 1; i > 0; --i)
            Power_[i-1] = (Power_[i]*Power_[i]) % Module;
        for (int i = Length_; i > 0; )
            if (Figure_[--i])
                Result_ = (Result_ * Power_[i]) % Module;
        return Result_;
    }
    public static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            long Number;
            System.out.println("Enter Number:");
            Number = scanner.nextInt();
            long Power;
            System.out.println("Enter Power:");
            Power = scanner.nextInt();

            long Module;
            System.out.println("Enter Module:");
            Module = scanner.nextInt();
            Solution s = new Solution();
            System.out.println(s.PowerByModule(Number, Power, Module));

            // После выполнения программы необходимо закрыть
            // потоки ввода и вывода
            scanner.close();
            // printWriter.close();
        }
    }
}
