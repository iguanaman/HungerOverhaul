package iguanaman.hungeroverhaul.util;

import java.util.Random;

public class RandomHelper
{
    public static final Random random = new Random();
    
    public static int getRandomIntFromRange(int min, int max)
    {
        return min + (max > min ? random.nextInt(1 + max - min) : 0);
    }
}
