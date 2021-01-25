// filled/hollow figures demonstrates Bridge Design Pattern,
// square is either hollow or square and is painted with a particular character,
// it is bridged over Figure --> Fill abstract body/handle
// Mikhail Nesterenko
// Moddified by Charles DeSmit 
// 11/10/2020

#include <iostream>

using std::cout; using std::endl; using std::cin;

// abstract body
class Fill {
public:
    Fill(char fillChar, char borderChar) :
        fillChar_(fillChar), borderChar_(borderChar) {}
    virtual char getBorder() = 0;
    virtual char getInternal() = 0;
    virtual ~Fill() {}
protected:
    char fillChar_; 
    char borderChar_;
};

// concrete body
class Hollow : public Fill {
public:
    Hollow(char fillChar, char borderChar) :Fill(fillChar, borderChar) {}
    char getBorder() override { return borderChar_; }
    char getInternal() override { return ' '; }
    ~Hollow() {}
};



// another concrete body
class Filled : public Fill {
public:
    Filled(char fillChar, char borderChar) :Fill(fillChar, borderChar) {}
    char getBorder() override { return fillChar_; }
    char getInternal() override { return fillChar_; }
    ~Filled() {}
};

class EnhancedFilled : public Fill {
public:
    EnhancedFilled(char fillChar, char borderChar) :Fill(fillChar, borderChar) {}
    char getBorder() override { return borderChar_; }
    char getInternal() override { return fillChar_; }
    ~EnhancedFilled() {}
};


// abstract handle
class Figure {
public:
    Figure(int size, Fill* fill) : size_(size), fill_(fill) {}
    virtual void changeFill(const Fill*) = 0;
    virtual void draw() = 0;
    virtual ~Figure() {}
protected:
    int size_;
    Fill* fill_;
};

// concrete handle
class Square : public Figure {
public:
    Square(int size, Fill* fill) : Figure(size, fill) {}
    void changeFill(const Fill*) override;
    void draw() override;
    

};

void Square::changeFill(const Fill* newFill) {
    *fill_ = *newFill;
}

void Square::draw() {
    for (int i = 0; i < size_; ++i) {
        for (int j = 0; j < size_; ++j)
            if (i == 0 || j == 0 || i == size_ - 1 || j == size_ - 1)
                cout << fill_->getBorder();
            else
                cout << fill_->getInternal();
        cout << endl;
    }
}


int main() {
    /*
    Fill* hollowPaintY = new Hollow('^');
    Fill* filledPaintStar = new Filled('*');


    Figure *smallBox = new Square(5, filledPaintStar);
    Figure *bigBox = new Square(10, hollowPaintY);

    smallBox->draw();
    cout << endl;
    bigBox -> draw();
    */

    // ask user for figure parameters  
    cout << "Enter fill character: ";
    char fchar; cin >> fchar; // Used in filled or the fill of enhancedfill
    cout << "Enter border character: ";
    char bchar; cin >> bchar; // Used in hollow or the border of enhancedfill
    cout << "Enter the changed fill character: ";
    char cChar; cin >> cChar;
    cout << "Filled, enhanced filled, hollow? [f/e/h] ";
    char ifFilled; cin >> ifFilled;
    cout << "Enter size: "; int size; cin >> size;

    /*Figure* userBox = new Square(size, ifFilled == 'f' ?
        static_cast<Fill*>(new Filled(fchar, fchar)) :
        static_cast<Fill*>(new Hollow(fchar, fchar))
    );*/
    Figure* userBox;
    if (ifFilled == 'f')
        userBox = new Square(size, 
            static_cast<Fill*>(new Filled(fchar, bchar)));
    else if (ifFilled == 'e')
        userBox = new Square(size, 
            static_cast<Fill*>(new EnhancedFilled(fchar, bchar)));
    else
        userBox = new Square(size, 
            static_cast<Fill*>(new Hollow(fchar, bchar)));


    /*
    Figure *userBox = ifFilled == 'f'?
       new Square(size, new Filled(fchar)):
       new Square(size, new Hollow(fchar));
    */

    userBox->draw();
    cout << endl;
    if (ifFilled =='h') // if hollow, change border, otherwise change fill
        userBox->changeFill(static_cast<Fill*>(new Filled(fchar, cChar)));
    else
        userBox->changeFill(static_cast<Fill*>(new Hollow(cChar, bchar)));
    userBox->draw();
    cout << endl;
}