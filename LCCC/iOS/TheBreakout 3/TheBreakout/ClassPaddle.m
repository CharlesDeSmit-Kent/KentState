//
//  ClassPaddle.m
//  TheBreakout
//
//  Created by UC224 on 4/13/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "ClassPaddle.h"

@implementation ClassPaddle

/*
 // Only override drawRect: if you perform custom drawing.
 // An empty implementation adversely affects performance during animation.
 - (void)drawRect:(CGRect)rect {
 // Drawing code
 }
 */
-(id) init
{
    self=[super initWithImage:[UIImage imageNamed:@"paddle"]];
    
    if (self!=nil)
    {
        [self setCDVx:2.0];
        [self setCDVy:0];
    }
    return self;
    
}

-(void) updateLocation
{
    if (self.touchPoint.x>self.center.x)
    {
        [self setCDVx:2.0f];
    }else
        if (self.touchPoint.x<self.center.x)
        {
            [self setCDVx:-2.0f];
        }else{
            [self setCDVx:0.0f];
        }
    
    
    [super updateLocation];
    int diffX=abs((int)(self.center.x-self.touchPoint.x));
    if (diffX<abs((int) self.CDVx))
    {
        CGPoint CDc=[self center];
        CDc.x=self.touchPoint.x;
        [self setCenter:CDc];
    }
}






@end
