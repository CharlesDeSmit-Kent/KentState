#pragma once
// collection class tempate used to hold list of nodes
// Charles DeSmit
// 9/23/20

#ifndef COLLECTION_HPP_
#define COLLECTION_HPP_
#include "list.hpp"

template <typename T>
class Collection {
public:
	Collection() : first_(nullptr) {}

	node<T>* getFirst() const;
	void setFirst(node<T>* const);

	void add(const T&);
	void remove(const T&);
	node<T>* last();
	void print();

	template <typename U>
	friend bool equal(const Collection<U>&, const Collection<U>&);

private:
	node<T> *first_;
};
//
//member functions for collection
//

//return first node
template <typename T>
node<T>* Collection<T>::getFirst() const{
	return first_;
}

//set the first node
template <typename T>
void Collection<T>::setFirst(node<T>* const first) {
	first_ = first;
}

//add a new node to the end of the list
template <typename T>
void Collection<T>::add(const T& data) {
	node<T>* addition = new node<T>;
	addition->setData(data);
	if (getFirst() == nullptr)
		setFirst(addition);
	else {
		node<T>* lastNode = last();
		lastNode->setNext(addition);
	}
}

// remove all instances of an element from the list
template <typename T> 
void Collection<T>::remove(const T& seeya) {
	node<T>* currentPtr = getFirst();
	node<T>* byeCurrent = new node<T>;
	while(currentPtr != nullptr) {
		if (currentPtr->getData() == seeya) {
			byeCurrent = currentPtr;
			currentPtr->getNext();
			delete byeCurrent;
		}
		else
			currentPtr->getNext();
	}
}

//return the last node added
template <typename T>
node<T>* Collection<T>::last() {
	node<T> *current = getFirst();
	while (current != nullptr)
		current->getNext();
	return current;
}

//print the list
template <typename T>
void Collection<T>::print() {
	for (node<T>* current = getFirst(); 
		current != nullptr; 
		current = current->getNext())

		std::cout << current->getData() << ' ';
}

//friend function comparing elements from 2 collections
template <typename U>
bool equal(const Collection<U>& lhs, const Collection<U>& rhs) {
	bool flag = true;
	node<U> *currentLhs = lhs.first_;
	node<U> *currentRhs = lhs.first_;
	while ((currentLhs != nullptr) && (currentRhs != nullptr)) {
		if (currentLhs->getData() != currentRhs->getData())
			flag = false;
		currentLhs->getNext();
		currentRhs->getNext();
	}
	return flag;
}


#endif // COLLECTION_HPP_