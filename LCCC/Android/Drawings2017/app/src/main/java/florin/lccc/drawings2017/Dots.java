package florin.lccc.drawings2017;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by uc224 on 3/7/17.
 */

public class Dots {

    private LinkedList<Dot> dots=new LinkedList<Dot>();
    private List<Dot> safeDots= Collections.unmodifiableList(dots);

    public void AddDot(float x, float y, int color, int diameter)
    {
        dots.add(new Dot(x,y,color,diameter));
    }
    public List<Dot> getDots()
    {
        return safeDots;
    }
    public Dot getLastDot()
    {
        return dots.getLast();
    }
}
