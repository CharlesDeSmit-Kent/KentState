/* CS4-53203: Systems Programming \
/* Name:\
/* Date:\
/* Assignment#.c\
\
\
\
/* Template for assignments. */

#include <stdio.h>
#include <stdlib.h>

struct numlist {    float *list; /* points to list of numbers */
                    int len; /* number of items in list */
                    float min, /* the minimal value in list */
                    max, /* the maximal value in list */
                    avg; /* the mean of the numbers */
};

void compute_stats(struct numlist *listptr){
    float total = 0.0;
    listptr->min = listptr->list[0];
    listptr->max = listptr->list[0];
    for (int i = 0; i < listptr->len; i++){
        if(listptr->list[i] < listptr->min)
            listptr->min = listptr->list[i];
        else if (listptr->list[i] > listptr->max)
            listptr->max = listptr->list[i];
        total = total + listptr->list[i];
    }
    listptr->avg = total / listptr->len;
}
void print_stats(struct numlist *printList){
    for(int i = 0; i < printList->len; i++){
        printf("%f\n", printList->list[i]);
    }
    printf("\nMax: %f\n Min: %f\n Avg: %f\n ", printList->max, printList->min, printList->avg);
}
int main()
{
    struct numlist newList;
    newList.len = 6;
    newList.list = (float*) malloc(newList.len);
    float j;
    for(int i = 0; i < newList.len; i++){
        j = (float) i+1;
        newList.list[i] = j;
    }
    compute_stats(&newList);
    print_stats(&newList);

    free(newList.list);
    return 0;
}
