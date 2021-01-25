// Written by Charles DeSmit
// 12/2/20

#include "process.hpp"

//Process implementation
int Process::nextID_ = 0;

Process::Process() {
	processID_ = nextID_;
	++nextID_;
	state_ = New_State::instance();
}
void Process::admitted() {
	state_->admitted(this);
}
void Process::interrupt() {
	state_->interrupt(this);
}
void Process::exit() {
	state_->exit(this);
}
void Process::eventWait() {
	state_->eventWait(this);
}
void Process::eventComplete() {
	state_->eventComplete(this);
}
void Process::schedulerDispatch() {
	state_->schedulerDispatch(this);
}
void Process::print(std::ostream& out) {
	out << "Process " << processID_ << " is ";
	state_-> print(out);
}

//State implementation

void New_State::admitted(Process* proc) {
	proc->stateChange(Ready::instance());
}
void Ready::schedulerDispatch(Process* proc) {
	proc->stateChange(Running::instance());
}
void Waiting::eventComplete(Process* proc) {
	proc->stateChange(Ready::instance());
}
void Running::eventWait(Process* proc) {
	proc->stateChange(Waiting::instance());
}
void Running::interrupt(Process* proc) {
	proc->stateChange(Ready::instance());
}
void Running::exit(Process* proc) {
	proc->stateChange(Terminated::instance());
}
