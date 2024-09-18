package polygon.service;

import polygon.entities.Rectangle;
import polygon.entities.Square;

public interface IPolygon {
    void display(Rectangle rectangle, Square square);
    void calArea(Rectangle rectangle, Square square);
}
