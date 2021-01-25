// header file for WordOccurence and WordList
// Charles DeSmit
// 9/16/2020

using std::string; using std::cout;
class WordOccurrence {
public:
	WordOccurrence(const string& word = "", int num = 1) : word_(word), num_(num) {}
	bool matchWord(const string &); // returns true if word matches stored
	void increment(); // increments number of occurrences
	string getWord() const;
	int getNum() const;

private:
	string word_;
	int num_;
};
//inline WordOccurrence::WordOccurrence(const string & word, int num)
//{
//}
bool WordOccurrence::matchWord(const string & rhs) {
	return this->word_ == rhs;
}
void WordOccurrence::increment() {
	num_ += 1;
}
string WordOccurrence::getWord() const{
	return word_;
}
int WordOccurrence::getNum() const{
	return num_;
}

class WordList {
public:
	// Default Constructor
	WordList(int size = 0) : size_(size), wordArray_(new WordOccurrence[size]) {} //{size_ = 0;}

	// Copy Constructor
	WordList(const WordList& other) :
		size_(other.size_),
		wordArray_(size_ > 0 ? new WordOccurrence[size_] : nullptr) {
		std::copy(other.wordArray_, other.wordArray_ + size_, wordArray_);
	}

	// Destructor
	~WordList() { delete[] wordArray_; }

	friend void swap(WordList& first, WordList& second) {
		std::swap(first.size_, second.size_);
		std::swap(first.wordArray_, second.wordArray_);
	}
	//Overload assignment
	WordList& operator=(const WordList& rhs) {
		if (this != &rhs) {
			delete[] wordArray_;
			size_ = rhs.size_;
			wordArray_ = size_ > 0 ? new WordOccurrence[size_] : nullptr; 
			std::copy(rhs.wordArray_, rhs.wordArray_ + size_, wordArray_);
		}
		return *this;
	}

	friend bool equal(const WordList&, const WordList&);
	void addWord(const string&);
	void sort();
	void print();
private:
	WordOccurrence *wordArray_; // a dynamically allocated array of WordOccurrences
								// may or may not be sorted
	int size_;
};

// Friend Comparison
bool equal(const WordList& first, const WordList& second) {
	return first.wordArray_ == second.wordArray_; //Might need to use for-loop to matchWord on each array instance
	/*for (int i = 0; i < first.size_; ++i) {
		first.wordArray_[i].matchWord(second.wordArray_[i])
	}*/
}

// Adds new wordOccurence or increments a preexisting one
void WordList::addWord(const string& word) {
	bool flag = false;
	WordOccurrence* temp;
	if (size_ != 0)
	{
		for (int i = 0; i < size_; ++i) {
			if (wordArray_[i].matchWord(word)) {
				wordArray_[i].increment();
				flag = true;
			}
		}
		/*if (!flag){
			size_ += 1;
			temp = new WordOccurrence[size_];
			for (int i = 0; i < size_-1; ++i) 
				temp[i] = wordArray_[i];
			temp[size_-1] = WordOccurrence(word);
			delete[] wordArray_;
			wordArray_ = temp;
		}*/
	}
	
	if (size_ == 0 || !flag) {
		size_ += 1;
		temp = new WordOccurrence[size_];
		for (int i = 0; i < size_-1; ++i)
			temp[i] = wordArray_[i];
		temp[size_-1] = WordOccurrence(word);
		delete[] wordArray_;
		wordArray_ = temp;
	}
}
//sorts the array, rarest words first
void WordList::sort() {
	int i, j;
	WordOccurrence key;
	for (i = 1; i < size_; i++)
	{
		key = wordArray_[i];
		j = i - 1;

		while (j >= 0 && wordArray_[j].getNum() > key.getNum())
		{
			wordArray_[j + 1] = wordArray_[j];
			j--;
		}
		wordArray_[j + 1] = key;

	}
}
//sorts, then prints array
void WordList::print() {
	this->sort();
	for (int i = 0; i < size_; ++i) {
		cout << wordArray_[i].getWord() << ": ";
		cout << wordArray_[i].getNum() << "\n";
	}
}