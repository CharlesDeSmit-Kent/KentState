//
//  ViewController.h
//  TheBreakout
//
//  Created by Dr. Florin Alan Muscutar on 4/12/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "ClassBall.h"
#import "ClassPaddle.h"
#import "ClassBrick.h"
#include <stdlib.h>

@interface ViewController : UIViewController

@property (strong, nonatomic) ClassBall *CDball;
@property (strong, nonatomic) ClassPaddle *CDpaddle;
@property (assign,nonatomic)  NSInteger CDScore;
@property (strong, nonatomic) CADisplayLink* CDdisplayLink;

@property (strong, nonatomic) NSMutableArray *CDourBricks;





@end

