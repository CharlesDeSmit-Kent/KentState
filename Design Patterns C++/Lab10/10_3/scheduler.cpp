#include <queue>
#include <set>
#include <cstdlib>
#include <ctime>
#include <algorithm>
#include "process2.hpp"

class Scheduler {
private:
	Process* prototype;

	std::deque<Process*> all;
	std::queue<Process*> ready;
	std::set<Process*> wait;

public:
	Scheduler() {
		prototype = new Process();
	}

	void report(std::ostream&);
	void create_process();
	void run(int);

};

void Scheduler::report(std::ostream& out) {

	out << "===========Report==========\n";
	for (Process* proc : all) {
		if (proc != nullptr)
			out << "\t";
		proc->print(out);
	}
	out << "============End============\n";
}

void Scheduler::create_process() {
	Process* temp = prototype->clone();
	temp->admitted();
	ready.push(temp);
	all.push_back(temp);
}

void Scheduler::run(int num) {
	srand(time(nullptr));
	for (int i = 0; i < num; ++i) {
		create_process();
	}

	report(std::cout);

	for (int i = 0; i < num; ++i) {

		if (rand() % 2 && !wait.empty()) {
			Process* proc = *(wait.begin());
			wait.erase(wait.begin());
			proc->eventComplete();
			ready.push(proc);
			std::cout << "Process " << proc->getProcessID() << " done waiting\n";
		}

		Process* proc = ready.front();
		ready.pop();
		proc->schedulerDispatch();
		proc->print(std::cout);
		int random = rand() % 3;
		std::cout << "Case: ";
		switch (random) {
		// exit
		case 0: {
			std::cout << "exit\n";
			auto itr = std::find(all.begin(), all.end(), proc);
			all.erase(itr);
			delete proc;
			break;
		}
		// event wait
		case 1: {
			std::cout << "event_wait\n";
			proc->eventWait();
			wait.insert(proc);
			break;
		}
		// interrupt
		case 2: {
			std::cout << "interupted\n";
			proc->interrupt();
			ready.push(proc);
			break;
		}
		}

		report(std::cout);
	}

}

int main() {
	Scheduler schedule;

	schedule.run(5);

	return 0;
}