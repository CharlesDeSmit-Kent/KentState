//
//  ClassBall.m
//  TheBreakout
//
//  Created by UC224 on 4/13/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "ClassBall.h"

@implementation ClassBall

/*
 // Only override drawRect: if you perform custom drawing.
 // An empty implementation adversely affects performance during animation.
 - (void)drawRect:(CGRect)rect {
 // Drawing code
 }
 */
-(id) init{
   
    self=[super initWithImage:[UIImage imageNamed:@"ball"]];
    
    [self setCDVx: 2.0f];
    [self setCDVy:-3.0f];
    
    /*
     CGRect frame = self.frame;
     frame.size.width = 100;
     self.frame = frame;
     */
    return self;
}

-(void) updateLocation
{
    [super updateLocation];
    [self bounceScreen];
}


@end
