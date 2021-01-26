//
//  ClassBrick.m
//  TheBreakout
//
//  Created by UC224 on 4/20/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "ClassBrick.h"

@implementation ClassBrick


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
        int CDr = arc4random_uniform(9);
        int CDdirect = arc4random_uniform(2);
        if(CDdirect==0)
            [self setCDVx:-CDr-1];
        else
            [self setCDVx:CDr+1];
        [self setCDVy:0.0f];
    }
    return self;
    
}


-(void) updateLocation
{
    [super updateLocation];
    [self bounceScreen];
}
-(void) bounceFromBrick:(MovingComponent *)CDball
{
    if ((self.center.x+self.bounds.size.width/2)<CDball.center.x) CDball.CDVx*=-1;
    
    else if ((self.center.x-self.bounds.size.width/2)>CDball.center.x) CDball.CDVx*=-1;
    
    else if ((self.center.y-self.bounds.size.height/2)>CDball.center.y) CDball.CDVy*=-1;
    
    else if ((self.center.y+self.bounds.size.height/2)<CDball.center.y) CDball.CDVy*=-1;
    
    else self.CDVy*=-1;
}
@end
