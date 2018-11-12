package com.baizhi.test;

public class MaoPao {
    public static void main(String[] args){
        int[] a={8,4,2,3,33,5,10};
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a.length-1;j++){
                if(a[j]>a[j+1]){
                    int s=a[j+1];
                    a[j+1]=a[j];
                    a[j]=s;
                }
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}
