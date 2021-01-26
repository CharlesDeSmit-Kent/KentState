//
//  ViewController.m
//  SoundPlayiOS
//
//  Created by Dr. Florin Alan Muscutar on 4/19/17.
//  Copyright © 2017 lorainccc. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
    NSString *filePath = [[NSBundle mainBundle] pathForResource:@"explosion"
                                                         ofType:@"mp3"];
    
    // Convert the file path to a URL.
    NSURL *fileURL = [[NSURL alloc] initFileURLWithPath:filePath];
    
    //Initialize the AVAudioPlayer.
    self.shortSoundPlayer = [[AVAudioPlayer alloc]
                        initWithContentsOfURL:fileURL error:nil];
    
    // Preloads the buffer and prepares the audio for playing.
    [self.shortSoundPlayer prepareToPlay];
    
    
    
    NSString *filePath2 = [[NSBundle mainBundle] pathForResource:@"ingamemusic"
                                                          ofType:@"mp3"];
    
    // Convert the file path to a URL.
    NSURL *fileURL2 = [[NSURL alloc] initFileURLWithPath:filePath2];
    
    //Initialize the AVAudioPlayer.
    self.longSoundPlayer = [[AVAudioPlayer alloc]
                          initWithContentsOfURL:fileURL2 error:nil];
    
    // Preloads the buffer and prepares the audio for playing.
    [self.longSoundPlayer prepareToPlay];
    
    
}
- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)playButton1Pressed:(UIButton *)sender {
    self.shortSoundPlayer.currentTime = 0;
    self.shortSoundPlayer.numberOfLoops=0;//once
   
    [self.shortSoundPlayer play];

}
- (IBAction)playButton2Pressed:(UIButton *)sender {
    self.longSoundPlayer.currentTime = 0;
    self.longSoundPlayer.numberOfLoops=-1;//infinite
    self.longSoundPlayer.volume=0.2;
    [self.longSoundPlayer play];

    
}
- (IBAction)stopButton1Pressed:(UIButton *)sender {
    [self.shortSoundPlayer stop];
    
}
- (IBAction)stopButton2Pressed:(UIButton *)sender {
    [self.longSoundPlayer stop];
}


@end
