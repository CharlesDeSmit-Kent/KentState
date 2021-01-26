//
//  ViewController.m
//  TheBreakout
//
//  Created by Dr. Florin Alan Muscutar on 4/12/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
@property (strong, nonatomic) IBOutlet UILabel *CDscoreLabel;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    
    _CDScore=10;
    _CDdisplayLink=[CADisplayLink displayLinkWithTarget:self selector:@selector(updateStuff)];
    
    [_CDdisplayLink addToRunLoop:[NSRunLoop currentRunLoop] forMode:NSDefaultRunLoopMode];
    
    _CDball=[ClassBall new];
    CGRect ourWindowFrame=[self.view frame];
    _CDball.center=CGPointMake(ourWindowFrame.size.width/2, ourWindowFrame.size.height/2);
    
    [self.view addSubview:_CDball];
    
    _CDpaddle=[ClassPaddle new];
    [_CDpaddle setFrame:CGRectMake(0, 0, _CDpaddle.bounds.size.width, _CDpaddle.bounds.size.height/2)];
    _CDpaddle.center=CGPointMake(ourWindowFrame.size.width/2, ourWindowFrame.size.height-3*_CDpaddle.bounds.size.height-5);
    _CDpaddle.touchPoint=_CDpaddle.center;
    //[self.paddle setTouchPoint:(_paddle.center)]; //same as above

    [self.view addSubview:_CDpaddle];
    
    //set up bricks
    _CDourBricks=[[NSMutableArray alloc] init];
    for(int i=0; i<=9; i++)
    {
        ClassBrick *CDtempBrick;
        CDtempBrick=[ClassBrick new];
        int CDr1 = arc4random_uniform(10);
        int CDr2 = arc4random_uniform(10);
        [CDtempBrick setFrame:CGRectMake(0, 0, CDtempBrick.bounds.size.width/2.2, CDtempBrick.bounds.size.height*2)];
        CDtempBrick.center=CGPointMake(CDtempBrick.bounds.size.width*CDr1+30, CDtempBrick.bounds.size.height*CDr2+10);
        CDtempBrick.CDhp = 1;
        [self.view addSubview:CDtempBrick];
        [self.CDourBricks addObject:CDtempBrick];
    }
    

}

-(void) touchesBegan:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event
{
    UITouch *theTouch=[touches anyObject];
    [_CDpaddle setTouchPoint:[theTouch locationInView:self.view]];
}
-(void) touchesMoved:(NSSet<UITouch *> *)touches withEvent:(UIEvent *)event
{
    UITouch *theTouch=[touches anyObject];
    [_CDpaddle setTouchPoint:[theTouch locationInView:self.view]];
}
-(void) updateStuff
{
    
    [_CDball updateLocation];
    [_CDpaddle updateLocation];
    
    float CDmaxVx = 5.0;
    
    if ([_CDball overlapsWith: _CDpaddle])
    {
        _CDball.CDVy*=-1;
        //placeholder
        _CDball.CDVx=CDmaxVx=(_CDball.center.x-_CDpaddle.center.x)/_CDpaddle.bounds.size.width/2;
    }
    
    int i=0;
    while (i<_CDourBricks.count)
    {
        ClassBrick *CDoneBrick=(ClassBrick *)[self.CDourBricks objectAtIndex:i];
        [CDoneBrick updateLocation];
        if ([CDoneBrick overlapsWith: _CDpaddle])
        {
            _CDScore-=10;
            CDoneBrick.CDVy*=-1;
            if (_CDourBricks.count<10)
            {
                ClassBrick *CDtempBrick;
                CDtempBrick=[ClassBrick new];
                int CDr = arc4random_uniform(10);
                [CDtempBrick setFrame:CGRectMake(0, 0, CDtempBrick.bounds.size.width/2.2, CDtempBrick.bounds.size.height*2)];
                CDtempBrick.center=CGPointMake(CDoneBrick.center.x, CDtempBrick.bounds.size.height*CDr+10);
                CDtempBrick.CDhp = 1;
                [self.view addSubview:CDtempBrick];
                [self.CDourBricks addObject:CDtempBrick];
            }
        }
        if ([_CDball overlapsWith:CDoneBrick])
        {
            _CDScore+=10;
            [CDoneBrick bounceFromBrick:_CDball];
            if (CDoneBrick.CDhp==1)
            {
                [CDoneBrick setFrame:CGRectMake(CDoneBrick.center.x, CDoneBrick.center.y, CDoneBrick.bounds.size.width/4, CDoneBrick.bounds.size.height/4)];
                CDoneBrick.CDVy=CDoneBrick.CDVx;
                CDoneBrick.CDVx=0.0;
                CDoneBrick.CDhp=0;
            }else
            {
                [_CDourBricks removeObject:CDoneBrick];
                [CDoneBrick removeFromSuperview];
            }
        }
        else
            i++;
        NSString *CDtext=[NSString stringWithFormat:@"Score:%ld",_CDScore];
        _CDscoreLabel.text=CDtext;
    }
}



- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}


@end
