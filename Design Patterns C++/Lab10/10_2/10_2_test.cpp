// Written by Charles DeSmit
// 12/2/20

#include "process.hpp"

int main() {
	Process test;

	test.print(std::cout); // NEW

	test.admitted();

	test.print(std::cout); // READY

	test.exit();

	test.print(std::cout); // READY

	test.schedulerDispatch();

	test.print(std::cout); // RUNNING

	test.interrupt();

	test.print(std::cout); // READY

	test.schedulerDispatch();

	test.print(std::cout); // RUNNING

	test.exit();

	test.print(std::cout); // TERMINATED

	Process test2;

	test2.print(std::cout); // NEW

	test2.admitted();

	test2.print(std::cout); // READY

	test2.exit();

	test2.print(std::cout); // READY

	test2.schedulerDispatch();

	test2.print(std::cout); // RUNNING

	test2.interrupt();

	test2.print(std::cout); // READY

	test2.schedulerDispatch();

	test2.print(std::cout); // RUNNING

	test2.exit();

	test2.print(std::cout); // TERMINATED

	return 0;
}