//
//  ClassBrick.h
//  TheBreakout
//
//  Created by UC224 on 4/20/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "MovingComponent.h"
#include <stdlib.h>


@interface ClassBrick : MovingComponent

@property (assign,nonatomic) int CDhp;

-(void) bounceFromBrick:(MovingComponent *) CDball;

@end
