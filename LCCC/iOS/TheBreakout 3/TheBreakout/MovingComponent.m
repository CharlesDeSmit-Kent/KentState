//
//  MovingComponent.m
//  TheBreakout
//
//  Created by UC224 on 4/13/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "MovingComponent.h"

@implementation MovingComponent

/*
 // Only override drawRect: if you perform custom drawing.
 // An empty implementation adversely affects performance during animation.
 - (void)drawRect:(CGRect)rect {
 // Drawing code
 }
 */
-(void) moveComponent
{
    
    CGPoint CDc=[self center];
    CDc.x+=self.CDVx;
    CDc.y+=self.CDVy;
    
    
    
    [self setCenter:CDc];
    
}

-(void) updateLocation
{
    [self moveComponent];
    
}

-(bool) overlapsWith:(MovingComponent *) CDobj2
{
    BOOL temp=true;
    int diffX=fabs(self.center.x-CDobj2.center.x);
    int diffY=fabs(self.center.y-CDobj2.center.y);
    
    if (CDobj2!=nil)
    {
        temp=temp&&(diffX<(self.bounds.size.width/2+CDobj2.bounds.size.width/2));
        temp=temp&&(diffY<(self.bounds.size.height/2+CDobj2.bounds.size.height/2));
        
    } else temp=false;
    
    return temp;
    
}

-(void) bounceScreen {
    //window frame is in superview
    CGPoint CDc=[self center];
    if ((CDc.x-self.bounds.size.width/2)<0)
        //bounce from the left
    
    {
        self.CDVx*=-1;
    }
    if (CDc.x>(self.superview.bounds.size.width-self.bounds.size.width/2))//bouncing from the right
    {
        _CDVx*=-1;//same as self.Vx;
    }
    if ((CDc.y-self.bounds.size.height/2)<0) //bounce from top
    {
        self.CDVy*=-1;
    }
    if (CDc.y>(self.superview.bounds.size.height-self.bounds.size.height/2))//bouncing from the bottom case to take out
    {
        _CDVy*=-1;//same as self.Vx;
    }
    //[self setCenter:c];//use if you modify the C
}
@end
