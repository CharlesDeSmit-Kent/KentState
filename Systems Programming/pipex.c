#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

    main(int argc, char *argv[])
    {
        int fd[2];
        pid_t childId;    

        if (pipe(fd) == -1) {
            perror("bad pipe1");
            exit(1);
        }

        if((childId = fork()) == -1){
            perror("fork");
            exit(1);
        } else if(childId == 0){

        }else{

        }
                
                
    }

void exec1() {
  // input from stdin (already done)
  // output to pipe1
  dup2(pipe1[1], 1);
  // close fds
  close(pipe1[0]);
  close(pipe1[1]);
  // exec
  execlp("ps", "ps", "aux", NULL);
  // exec didn't work, exit
  perror("bad exec ps");
  _exit(1);
}

void exec2() {
  // input from pipe1
  dup2(pipe1[0], 0);
  // output to pipe2
  dup2(pipe2[1], 1);
  // close fds
  close(pipe1[0]);
  close(pipe1[1]);
  close(pipe2[0]);
  close(pipe2[1]);
  // exec
  execlp("grep", "grep", "root", NULL);
  // exec didn't work, exit
  perror("bad exec grep root");
  _exit(1);
}

void exec3() {
  // input from pipe2
  dup2(pipe2[0], 0);
  // output to stdout (already done)
  // close fds
  close(pipe2[0]);
  close(pipe2[1]);
  // exec
  execlp("grep", "grep", "sbin", NULL);
  // exec didn't work, exit
  perror("bad exec grep sbin");
  _exit(1);
}