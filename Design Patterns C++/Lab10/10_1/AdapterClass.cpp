// figures: class adapter pattern
// Mikhail Nesterenko
// Modified by Charles DeSmit
// 11/24/2020

#include <iostream>

using std::cout; using std::endl;
using std::cin;

// base interface
class Figure {
public:
    virtual void draw() = 0;
    virtual ~Figure() {}
    virtual int size() = 0;
    virtual void resize(int newSize) = 0;
};

// adaptee/implementer
class LegacyRectangle {
public:
    LegacyRectangle(int topLeftX,
        int topLeftY,
        int bottomRightX,
        int bottomRightY) :
        topLeftX_(topLeftX),
        topLeftY_(topLeftY),
        bottomRightX_(bottomRightX),
        bottomRightY_(bottomRightY) {}

    int getTopLeftX() { return topLeftX_; }
    int getTopLeftY() { return topLeftY_; }
    int getBottomRightX() { return bottomRightX_; }
    int getBottomRightY() { return bottomRightY_; }

    void oldDraw() {
        for (int i = 0; i < bottomRightY_; ++i) {
            for (int j = 0; j < bottomRightX_; ++j)
                if (i >= topLeftY_ && j >= topLeftX_)
                    cout << '*';
                else
                    cout << ' ';
            cout << endl;
        }
    }
    void move(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        topLeftX_ = topLeftX;
        topLeftY_ = topLeftY;
        bottomRightX_ = bottomRightX;
        bottomRightY_ = bottomRightY;
        oldDraw();
    }
    // defining top/left and bottom/right coordinates 
private:
    int topLeftX_;
    int topLeftY_;
    int bottomRightX_;
    int bottomRightY_;
};

// adapter uses multiple inheritance to inherit
// interface and implementation
class SquareAdapter : public Figure,
    private LegacyRectangle {
public:
    SquareAdapter(int size) :
        LegacyRectangle(0, 0, size, size) {};
    void draw() override {
        oldDraw();
    }
    int size() { return (getBottomRightY()); }
    void resize(int newSize) { move(0, 0, newSize, newSize); }
};


int main() {
    //first square
    cout << "Enter size of the square: ";
    int insize; cin >> insize;
    Figure* square = new SquareAdapter(insize);
    square->draw();
    //second square
    cout << "Enter a new size (previous size: " << square->size() << ") ";
    cin >> insize;
    square->resize(insize);
    //square->draw();
}