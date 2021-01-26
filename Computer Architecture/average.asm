#
# Charles DeSmit
# 4/10/18
# 
#
# The code then prompts the user for an integer value, which will be
# the amount of times the user is prompted to enter a 3 decimal number.
#
# The code adds the floating points together and divides by the integer
# after being converted to a float. The result is output to the user.
#
#
            .data      # data segment
	    .align 2   # align the next string on a word boundary
outpAuth:   .asciiz  "This is Charles DeSmit presenting average.\n"
outpPrompt: .asciiz  "How many numbers would you like to average? "
	    .align 2   #align next prompt on a word boundary
outpStr:    .asciiz  "Please enter a 3 digit decimal d.dd: "
            .align 2   # align users input on a word boundary
outpResult: .asciiz  "The average is: "
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

	li, $v0,5 		# system call 5 for read in integer
	syscall
	move $t0,$v0		# stores integer in $t0
###############################################################
	
	add $t1, $zero, $zero	# initialize loop counter to 0
	mtc1 $zero, $f12	# initialize $f12 (float sum) to 0
loop:
	la $a0,outpPrompt	# system call 4 for print string needs address of string in $a0
	li $v0,4		# system call 4 for print string needs 4 in $v0
	syscall
	
	li, $v0,6 		# system call 6 for read in float
	syscall
	
	add.s $f12, $f0, $f12	# adds the input into $f12
	addi $t1, $t1, 1	# increments the counter by 1
	blt $t1, $t0, loop	# loop back if the counter < user input integer
	
# loop end
###############################################################
	mtc1 $t0, $f2 		# move the integer input into a float register
	cvt.s.w $f4, $f2 	# convert the integer input into a float
	div.s $f12, $f12, $f4   # $f12 = sum of the floating inputs / amount of inputs

# system call to display "The average is: "
	 la $a0,outpResult 	# system call 4 for print string needs address of string in $a0
	 li $v0,4		# system call 4 for print string needs 4 in $v0
	 syscall  	
	
################################################################
    	li $v0, 2		# system call 2 for print float
    	syscall

#
# Exit gracefully
         li   $v0, 10       # system call for exit
         syscall            # close file
###############################################################
