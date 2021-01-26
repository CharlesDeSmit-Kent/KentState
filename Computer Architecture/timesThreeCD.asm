# Starter code for threeTimes.asm
# Put in comments your name and date please.  You will be
# revising this code.
#
# Dianne Foreback 
# 
# Charles DeSmit
# 2/27/18
# 
# This code displays the authors name (you must change
# outpAuth to display YourFirstName and YourLastName".
#
# The code then prompts the user for 3 integer values.
# The code outputs the summation of these 3 values multiplied by 3.
#
# In MARS, make certain in "Settings" to check
# "popup dialog for input syscalls 5,6,7,8,12"
#
            .data      # data segment
	    .align 2   # align the next string on a word boundary
outpAuth:   .asciiz  "This is Charles DeSmit presenting threeTimes.\n"
outpPrompt: .asciiz  "Please enter an integer: "
	    .align 2   #align next prompt on a word boundary
outpStr:    .asciiz  "The sum of your numbers multiplied by 3 is: "
            .align 2   # align users input on a word boundary
#
# main begins
            .text      # code section begins
            .globl	main 
main:  
###############################################################
# system call to display the author of this code
	 la $a0,outpAuth	# system call 4 for print string needs address of string in $a0
	 li $v0,4		# system call 4 for print string needs 4 in $v0
	 syscall	

#
# system call to prompt user for input
	 la $a0,outpPrompt	# system call 4 for print string needs address of string in $a0
	 li $v0,4		# system call 4 for print string needs 4 in $v0
	 syscall	
###############################################################
# write a system call to read the user's integer value
	li, $v0,5 		# system call 5 for read in integer
	syscall
	move $t0,$v0		# stores integer 1 in $t0

# We have not studied looping, so you will need to repeat the prompt for input
# and do the calculation as you see fit
	la $a0,outpPrompt	# system call 4 for print string needs address of string in $a0
	li $v0,4		# system call 4 for print string needs 4 in $v0
	syscall
	
	li, $v0,5 		# system call 5 for read in integer
	syscall
	move $t1,$v0		# stores integer 2 in $t1
	
	la $a0,outpPrompt	# system call 4 for print string needs address of string in $a0
	li $v0,4		# system call 4 for print string needs 4 in $v0
	syscall
	
	li, $v0,5 		# system call 5 for read in integer
	syscall
	move $t2,$v0		# stores integer 3 in $t2
	
	add $s0, $t0, $t1	# adds num 1 and num 2
	add $s0, $s0, $t2	# adds the previous sum and num 3
	add $s1, $s0, $s0	# adds the sum of all 3 numbers to itself (sum * 2)
	add $s1, $s1, $s0	# adds the sum of all 3 numbers to previous result (2(sum) + sum)

#
# system call to display "The sum of your numbers multiplied by 3 is: "
	 la $a0,outpStr 	# system call 4 for print string needs address of string in $a0
	 li $v0,4		# system call 4 for print string needs 4 in $v0
	 syscall  	
################################################################
# write a system call to display the calculation

    	li $v0, 1		# system call 1 for print integer
    	move $a0, $s1		# system call 1 need address for integer in $s1
    	syscall

#
# Exit gracefully
         li   $v0, 10       # system call for exit
         syscall            # close file
###############################################################