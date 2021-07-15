package week04.conc0302.atomic;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:14
 * @Version: 1.0
 */
public class Count {
    private int num = 0;
    public int add(){
        return num++;
    }
    public int getNum(){
        return num;
    }
}
