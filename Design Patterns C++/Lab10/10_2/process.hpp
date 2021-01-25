// Written by Charles DeSmit
// 12/2/20

#include <iostream>
#include <string>

//Class declaration
class State;

//Process class
class Process {
private:
	static int nextID_;
	int processID_;
	State* state_;

public:
	Process();

	void admitted();
	void interrupt();
	void exit();
	void eventWait();
	void eventComplete();
	void schedulerDispatch();
	void print(std::ostream&);
	void stateChange(State* sta) { state_ = sta; }
};
//State design pattern
class State {
public:
	virtual void admitted(Process*) {}
	virtual void interrupt(Process*) {}
	virtual void exit(Process*) {}
	virtual void eventWait(Process*) {}
	virtual void eventComplete(Process*) {}
	virtual void schedulerDispatch(Process*) {}
	virtual void print(std::ostream&) = 0;

};

//Each of the states are their own class with Singleton design pattern
class New_State : public State {
private:
	New_State() {}
public:
	static State* instance() {
		static State* singleton = new New_State();
		return singleton;
	}
	void admitted(Process* proc) override;
	void print(std::ostream& out) override {
		out << "new\n";
	}

};


class Ready : public State {
private:
	Ready() {}
public:
	static State* instance() {
		static State* singleton = new Ready();
		return singleton;
	}
	void schedulerDispatch(Process* proc) override;
	void print(std::ostream& out) override {
		out << "ready\n";
	}
};

class Waiting : public State {
private:
	Waiting() {}
public:
	static State* instance() {
		static State* singleton = new Waiting();
		return singleton;
	}

	void eventComplete(Process* proc) override;
	void print(std::ostream& out) override {
		out << "waiting\n";
	}
};

class Running : public State {
private:
	Running() {}
public:
	static State* instance() {
		static State* singleton = new Running();
		return singleton;
	}
	void exit(Process* proc) override;
	void eventWait(Process* proc) override;
	void interrupt(Process* proc) override;
	void print(std::ostream& out) override {
		out << "running\n";
	}
};

class Terminated : public State {
private:
	Terminated() {}
public:
	static State* instance() {
		static State* singleton = new Terminated();
		return singleton;
	}
	void print(std::ostream& out) override {
		out << "terminated\n";
	}
};
