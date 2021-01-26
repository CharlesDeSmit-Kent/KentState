//
//  ViewController.h
//  SoundPlayiOS
//
//  Created by Dr. Florin Alan Muscutar on 4/19/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <AVFoundation/AVFoundation.h>
#include <AudioToolbox/AudioToolbox.h>

@interface ViewController : UIViewController

@property (strong, nonatomic) AVAudioPlayer *shortSoundPlayer;
@property (strong,nonatomic) AVAudioPlayer *longSoundPlayer;

@end

