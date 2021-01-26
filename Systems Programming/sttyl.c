/* showtty.c
 *	displays some current tty settings
 */

#define 	IFLAG_TABLE_ID			1
#define 	OFLAG_TABLE_ID			2
#define 	LFLAG_TABLE_ID			3
#define		CCSETTINGS_TABLE_ID		4

#include	<stdio.h>
#include	<termios.h>
#include	<stdlib.h>
#include 	<string.h>
#include	<fcntl.h>
#include	<unistd.h>

main(int argc, char *argv[])
{
	struct	termios ttyinfo;	/* this struct holds tty info */
						
	if ( tcgetattr( 0 , &ttyinfo ) == -1 ){   /* get info */
		perror( "cannot get params about stdin");
		exit(1);
	}
						/* show info */
	/*showbaud ( cfgetospeed( &ttyinfo ) );	/* get + show baud rate	/
	printf("The erase character is ascii %d, Ctrl-%c\n",
			ttyinfo.c_cc[VERASE], ttyinfo.c_cc[VERASE]-1+'A');
	printf("The line kill character is ascii %d, Ctrl-%c\n",
			ttyinfo.c_cc[VKILL], ttyinfo.c_cc[VKILL]-1+'A'); 
	*/

	/*show_some_flags( &ttyinfo );		/* show misc. flags	*/

	processArgs(&ttyinfo,argc, argv);

	if ( tcsetattr(0, TCSANOW, &ttyinfo) == -1 ){   
		perror( "Could not write new settings to file");
		exit(1);
	}
	
	return 0;
}

showbaud( int thespeed )
/*
 *	prints the speed in english
 */
{
	printf("the baud rate is ");
	switch ( thespeed ){
		case B300:	printf("300\n");	break;
		case B600:	printf("600\n"); 	break;
		case B1200:	printf("1200\n"); 	break;
		case B1800:	printf("1800\n"); 	break;
		case B2400:	printf("2400\n"); 	break;
		case B4800:	printf("4800\n"); 	break;
		case B9600:	printf("9600\n"); 	break;
		default:	printf("Fast\n");	break;
	}
}

struct flaginfo { int	fl_value; char	*fl_name; };

struct flaginfo input_flags[] = {

		IGNBRK	,	"Ignore break condition",
		BRKINT	,	"Signal interrupt on break",
		IGNPAR	,	"Ignore chars with parity errors",
		PARMRK	,	"Mark parity errors",
		INPCK	,	"Enable input parity check",
		ISTRIP	,	"Strip character",
		INLCR	,	"Map NL to CR on input",
		IGNCR	,	"Ignore CR",
		ICRNL	,	"Map CR to NL on input",
		IXON	,	"Enable start/stop output control",
		/* _IXANY  ,	"enable any char to restart output",	*/
		IXOFF   ,	"Enable start/stop input control",
		0	,	NULL };

struct flaginfo local_flags[] = {
		ISIG	,	"Enable signals",
		ICANON	,	"Canonical input (erase and kill)",
		/* _XCASE	,	"Canonical upper/lower appearance", */
		ECHO	,	"Enable echo",
		ECHOE	,	"Echo ERASE as BS-SPACE-BS",
		ECHOK	,	"Echo KILL by starting new line",
		0	,	NULL };

struct flaginfo output_flags[] = {
		{OLCUC	,	"olcuc"}, 
		{ONLCR	,	"onlcr"},
		{0		,	NULL}
};

struct flaginfo settings_table[] = {
	{VERASE	,	"erase"},
	{VKILL	,	"kill"},
	{VINTR	,	"intr"},
	{0		,	NULL}
};

show_some_flags( struct termios *ttyp )
/*
 *	show the values of two of the flag sets_: c_iflag and c_lflag
 *	adding c_oflag and c_cflag is pretty routine - just add new
 *	tables above and a bit more code below.
 */
{
	show_flagset( ttyp->c_iflag, input_flags );
	show_flagset( ttyp->c_lflag, local_flags );
}

show_flagset( int thevalue, struct flaginfo thebitnames[] )
/*
 * check each bit pattern and display descriptive title
 */
{
	int	i;
	
	for ( i=0; thebitnames[i].fl_value ; i++ ) {
		printf( "  %s is ", thebitnames[i].fl_name);
		if ( thevalue & thebitnames[i].fl_value )
			printf("ON\n");
		else
			printf("OFF\n");
	}
}

void showSettings(struct termios *ttyp, struct flaginfo settings[]){
	int i, index;
	char control;
	char * name;

	for ( i=0; settings[i].fl_name ; i++ ) {
		index=settings[i].fl_value; 
		control = ttyp->c_cc[index]; 	
		name = settings[i].fl_name;
		printf("%s = %c; ", name, control);
	}
	printf("\n");
}

int flagTableSearch(char * arg, struct termios * ttyp){
	struct flaginfo * table;
	tcflag_t * flag; 
	tcflag_t fl_value, off, on; 
	int index; 

	if((index = tableSearch(input_flags, arg)) >= 0 ){
		table = input_flags;
		flag = &ttyp->c_iflag; 
	}else if((index = tableSearch(output_flags, arg)) >= 0 ){
		table = output_flags;
		flag = &ttyp->c_oflag; 
	}else if((index = tableSearch(local_flags, arg)) >= 0 ){
		table = local_flags;
		flag = &ttyp->c_lflag; 
	}else{
		return 0; 
	}

	fl_value = table[index].fl_value;	
	on = ((*flag) | (fl_value));		
	off = ((*flag) & (fl_value));		

	*flag = (arg[0]=='-')?off:on;

	return 1; 
}

int tableSearch(struct flaginfo settings[], char *name){
	int i, j, start = 0;
	char * setting;
	char * temp = malloc(sizeof(name)-1);

	if (name[0] == '-'){
		for(j = 0; j < strlen(name); j++){
			if(j == 0)continue; 
			temp[j - 1] = name[j];
		}
	}else{
		temp = name;
	}

	for(i = 0;(setting = settings[i].fl_name); i++){
		if(!strcmp(setting, temp)){
			return i;
		}
	}
	return -1;
}

void processArgs(struct termios * ttyp, int argc, char * argv[]){
	int i;
	int index;
	char * arg;
	char newchar;
	
	if (argc==1){ 	
		showbaud(cfgetospeed(ttyp)); 
		showSettings(ttyp, settings_table); 
		show_some_flags(ttyp);
	}
	else if (argc>=2){		
		for (i=1;i<argc;i++){
			arg = argv[i];		
			if((index=tableSearch(settings_table, arg)) >= 0 ){
				if((i+1) >= argc) {
					fprintf(stderr, "Expected a char after %s\n",arg);
					exit(1); 
				}
				newchar = argv[i + 1][0];			
				printf("cc_index: %d ; erase_index: %d \n",settings_table[index].fl_value, VERASE);
				ttyp->c_cc[settings_table[index].fl_value] = newchar;
				printf("new char is %c\n",ttyp->c_cc[settings_table[index].fl_value]);
				i++; 
				continue;
			}else{ 
				if(flagTableSearch(arg, ttyp) == 0){
					fprintf(stderr, "Invalid argument: %s\n",argv[i]);
					exit(1);
				}
			}
		}
	} 
}