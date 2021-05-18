
namespace FehCalculator_WFA
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.button1 = new System.Windows.Forms.Button();
            this.textBox_grail = new System.Windows.Forms.TextBox();
            this.textBox_copies = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label_result = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBox_upgradeFlower = new System.Windows.Forms.TextBox();
            this.textBox_currentFlower = new System.Windows.Forms.TextBox();
            this.checkBox_flower = new System.Windows.Forms.CheckBox();
            this.label6 = new System.Windows.Forms.Label();
            this.button_flowerCalc = new System.Windows.Forms.Button();
            this.label_flowerResult = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.upDown_tier1 = new System.Windows.Forms.NumericUpDown();
            this.label8 = new System.Windows.Forms.Label();
            this.label9 = new System.Windows.Forms.Label();
            this.label10 = new System.Windows.Forms.Label();
            this.label11 = new System.Windows.Forms.Label();
            this.label12 = new System.Windows.Forms.Label();
            this.label13 = new System.Windows.Forms.Label();
            this.label14 = new System.Windows.Forms.Label();
            this.upDown_tier2 = new System.Windows.Forms.NumericUpDown();
            this.upDown_tier3 = new System.Windows.Forms.NumericUpDown();
            this.upDown_tier4 = new System.Windows.Forms.NumericUpDown();
            this.upDown_tier5 = new System.Windows.Forms.NumericUpDown();
            this.button_codesCalc = new System.Windows.Forms.Button();
            this.label_codesResult = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier2)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier3)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier4)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier5)).BeginInit();
            this.SuspendLayout();
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(402, 27);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 0;
            this.button1.Text = "Calculate";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // textBox_grail
            // 
            this.textBox_grail.Location = new System.Drawing.Point(296, 29);
            this.textBox_grail.Name = "textBox_grail";
            this.textBox_grail.Size = new System.Drawing.Size(100, 20);
            this.textBox_grail.TabIndex = 1;
            this.textBox_grail.Text = "0";
            // 
            // textBox_copies
            // 
            this.textBox_copies.Location = new System.Drawing.Point(296, 56);
            this.textBox_copies.Name = "textBox_copies";
            this.textBox_copies.Size = new System.Drawing.Size(100, 20);
            this.textBox_copies.TabIndex = 2;
            this.textBox_copies.Text = "0";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(32, 34);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(218, 13);
            this.label1.TabIndex = 3;
            this.label1.Text = "How many copies are you buying with grails?";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(32, 59);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(217, 13);
            this.label2.TabIndex = 4;
            this.label2.Text = "How many copies have you already bought?";
            // 
            // label_result
            // 
            this.label_result.AutoSize = true;
            this.label_result.Location = new System.Drawing.Point(402, 59);
            this.label_result.Name = "label_result";
            this.label_result.Size = new System.Drawing.Size(0, 13);
            this.label_result.TabIndex = 5;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(328, 9);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(78, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Grail Calculator";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(35, 124);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(255, 13);
            this.label4.TabIndex = 7;
            this.label4.Text = "How many times is the Flower level being increased?";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(35, 150);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(159, 13);
            this.label5.TabIndex = 8;
            this.label5.Text = "What is the current flower level?";
            // 
            // textBox_upgradeFlower
            // 
            this.textBox_upgradeFlower.Location = new System.Drawing.Point(296, 121);
            this.textBox_upgradeFlower.Name = "textBox_upgradeFlower";
            this.textBox_upgradeFlower.Size = new System.Drawing.Size(100, 20);
            this.textBox_upgradeFlower.TabIndex = 9;
            this.textBox_upgradeFlower.Text = "0";
            // 
            // textBox_currentFlower
            // 
            this.textBox_currentFlower.Location = new System.Drawing.Point(296, 147);
            this.textBox_currentFlower.Name = "textBox_currentFlower";
            this.textBox_currentFlower.Size = new System.Drawing.Size(100, 20);
            this.textBox_currentFlower.TabIndex = 10;
            this.textBox_currentFlower.Text = "0";
            // 
            // checkBox_flower
            // 
            this.checkBox_flower.AutoSize = true;
            this.checkBox_flower.Location = new System.Drawing.Point(296, 173);
            this.checkBox_flower.Name = "checkBox_flower";
            this.checkBox_flower.Size = new System.Drawing.Size(120, 17);
            this.checkBox_flower.TabIndex = 11;
            this.checkBox_flower.Text = "Pre-Book III Infantry";
            this.checkBox_flower.UseVisualStyleBackColor = true;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(35, 174);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(184, 13);
            this.label6.TabIndex = 12;
            this.label6.Text = "Is the unit a pre-Book III Infantry unit?";
            // 
            // button_flowerCalc
            // 
            this.button_flowerCalc.Location = new System.Drawing.Point(402, 119);
            this.button_flowerCalc.Name = "button_flowerCalc";
            this.button_flowerCalc.Size = new System.Drawing.Size(75, 23);
            this.button_flowerCalc.TabIndex = 13;
            this.button_flowerCalc.Text = "Calculate";
            this.button_flowerCalc.UseVisualStyleBackColor = true;
            this.button_flowerCalc.Click += new System.EventHandler(this.button_flowerCalc_Click);
            // 
            // label_flowerResult
            // 
            this.label_flowerResult.AutoSize = true;
            this.label_flowerResult.Location = new System.Drawing.Point(402, 150);
            this.label_flowerResult.Name = "label_flowerResult";
            this.label_flowerResult.Size = new System.Drawing.Size(0, 13);
            this.label_flowerResult.TabIndex = 14;
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(328, 89);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(88, 13);
            this.label7.TabIndex = 15;
            this.label7.Text = "Flower Calculator";
            // 
            // upDown_tier1
            // 
            this.upDown_tier1.Location = new System.Drawing.Point(81, 262);
            this.upDown_tier1.Maximum = new decimal(new int[] {
            6,
            0,
            0,
            0});
            this.upDown_tier1.Name = "upDown_tier1";
            this.upDown_tier1.Size = new System.Drawing.Size(30, 20);
            this.upDown_tier1.TabIndex = 16;
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(310, 211);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(115, 13);
            this.label8.TabIndex = 17;
            this.label8.Text = "Divine Code Calculator";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(38, 238);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(282, 13);
            this.label9.TabIndex = 18;
            this.label9.Text = "How many combat manuals from each tier are you buying?";
            // 
            // label10
            // 
            this.label10.AutoSize = true;
            this.label10.Location = new System.Drawing.Point(41, 264);
            this.label10.Name = "label10";
            this.label10.Size = new System.Drawing.Size(34, 13);
            this.label10.TabIndex = 19;
            this.label10.Text = "Tier 1";
            // 
            // label11
            // 
            this.label11.AutoSize = true;
            this.label11.Location = new System.Drawing.Point(117, 264);
            this.label11.Name = "label11";
            this.label11.Size = new System.Drawing.Size(34, 13);
            this.label11.TabIndex = 20;
            this.label11.Text = "Tier 2";
            // 
            // label12
            // 
            this.label12.AutoSize = true;
            this.label12.Location = new System.Drawing.Point(193, 264);
            this.label12.Name = "label12";
            this.label12.Size = new System.Drawing.Size(34, 13);
            this.label12.TabIndex = 21;
            this.label12.Text = "Tier 3";
            // 
            // label13
            // 
            this.label13.AutoSize = true;
            this.label13.Location = new System.Drawing.Point(269, 264);
            this.label13.Name = "label13";
            this.label13.Size = new System.Drawing.Size(34, 13);
            this.label13.TabIndex = 22;
            this.label13.Text = "Tier 4";
            // 
            // label14
            // 
            this.label14.AutoSize = true;
            this.label14.Location = new System.Drawing.Point(345, 264);
            this.label14.Name = "label14";
            this.label14.Size = new System.Drawing.Size(34, 13);
            this.label14.TabIndex = 23;
            this.label14.Text = "Tier 5";
            // 
            // upDown_tier2
            // 
            this.upDown_tier2.Location = new System.Drawing.Point(157, 262);
            this.upDown_tier2.Maximum = new decimal(new int[] {
            6,
            0,
            0,
            0});
            this.upDown_tier2.Name = "upDown_tier2";
            this.upDown_tier2.Size = new System.Drawing.Size(30, 20);
            this.upDown_tier2.TabIndex = 24;
            // 
            // upDown_tier3
            // 
            this.upDown_tier3.Location = new System.Drawing.Point(233, 262);
            this.upDown_tier3.Maximum = new decimal(new int[] {
            6,
            0,
            0,
            0});
            this.upDown_tier3.Name = "upDown_tier3";
            this.upDown_tier3.Size = new System.Drawing.Size(30, 20);
            this.upDown_tier3.TabIndex = 25;
            // 
            // upDown_tier4
            // 
            this.upDown_tier4.Location = new System.Drawing.Point(309, 262);
            this.upDown_tier4.Maximum = new decimal(new int[] {
            6,
            0,
            0,
            0});
            this.upDown_tier4.Name = "upDown_tier4";
            this.upDown_tier4.Size = new System.Drawing.Size(30, 20);
            this.upDown_tier4.TabIndex = 26;
            // 
            // upDown_tier5
            // 
            this.upDown_tier5.Location = new System.Drawing.Point(385, 262);
            this.upDown_tier5.Maximum = new decimal(new int[] {
            6,
            0,
            0,
            0});
            this.upDown_tier5.Name = "upDown_tier5";
            this.upDown_tier5.Size = new System.Drawing.Size(30, 20);
            this.upDown_tier5.TabIndex = 27;
            // 
            // button_codesCalc
            // 
            this.button_codesCalc.Location = new System.Drawing.Point(421, 259);
            this.button_codesCalc.Name = "button_codesCalc";
            this.button_codesCalc.Size = new System.Drawing.Size(75, 23);
            this.button_codesCalc.TabIndex = 28;
            this.button_codesCalc.Text = "Calculate";
            this.button_codesCalc.UseVisualStyleBackColor = true;
            this.button_codesCalc.Click += new System.EventHandler(this.button_codesCalc_Click);
            // 
            // label_codesResult
            // 
            this.label_codesResult.AutoSize = true;
            this.label_codesResult.Location = new System.Drawing.Point(502, 264);
            this.label_codesResult.Name = "label_codesResult";
            this.label_codesResult.Size = new System.Drawing.Size(0, 13);
            this.label_codesResult.TabIndex = 29;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label_codesResult);
            this.Controls.Add(this.button_codesCalc);
            this.Controls.Add(this.upDown_tier5);
            this.Controls.Add(this.upDown_tier4);
            this.Controls.Add(this.upDown_tier3);
            this.Controls.Add(this.upDown_tier2);
            this.Controls.Add(this.label14);
            this.Controls.Add(this.label13);
            this.Controls.Add(this.label12);
            this.Controls.Add(this.label11);
            this.Controls.Add(this.label10);
            this.Controls.Add(this.label9);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.upDown_tier1);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label_flowerResult);
            this.Controls.Add(this.button_flowerCalc);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.checkBox_flower);
            this.Controls.Add(this.textBox_currentFlower);
            this.Controls.Add(this.textBox_upgradeFlower);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label_result);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox_copies);
            this.Controls.Add(this.textBox_grail);
            this.Controls.Add(this.button1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier2)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier3)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier4)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.upDown_tier5)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox_grail;
        private System.Windows.Forms.TextBox textBox_copies;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label_result;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBox_upgradeFlower;
        private System.Windows.Forms.TextBox textBox_currentFlower;
        private System.Windows.Forms.CheckBox checkBox_flower;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button button_flowerCalc;
        private System.Windows.Forms.Label label_flowerResult;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.NumericUpDown upDown_tier1;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label9;
        private System.Windows.Forms.Label label10;
        private System.Windows.Forms.Label label11;
        private System.Windows.Forms.Label label12;
        private System.Windows.Forms.Label label13;
        private System.Windows.Forms.Label label14;
        private System.Windows.Forms.NumericUpDown upDown_tier2;
        private System.Windows.Forms.NumericUpDown upDown_tier3;
        private System.Windows.Forms.NumericUpDown upDown_tier4;
        private System.Windows.Forms.NumericUpDown upDown_tier5;
        private System.Windows.Forms.Button button_codesCalc;
        private System.Windows.Forms.Label label_codesResult;
    }
}

