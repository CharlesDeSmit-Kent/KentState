//
//  MovingComponent.h
//  TheBreakout
//
//  Created by UC224 on 4/13/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MovingComponent : UIImageView

@property (assign, nonatomic) float CDspeed;
@property (assign,nonatomic) float CDVx;
@property (assign, nonatomic) float CDVy;
@property (assign, nonatomic) CGPoint touchPoint;



-(void) updateLocation;
-(void) bounceScreen;
-(void) moveComponent;
-(bool) overlapsWith:(MovingComponent *) CDobj2;



@end
