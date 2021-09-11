
namespace FehCalculator_WFA
{
    partial class FlowerCalc
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
            this.buttonGrailForm = new System.Windows.Forms.Button();
            this.label_flowerResult = new System.Windows.Forms.Label();
            this.button_flowerCalc = new System.Windows.Forms.Button();
            this.label_infantry = new System.Windows.Forms.Label();
            this.checkBox_infantry = new System.Windows.Forms.CheckBox();
            this.label5 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.numericUpDown_upgradeFlower = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown_currentFlower = new System.Windows.Forms.NumericUpDown();
            this.listView1 = new System.Windows.Forms.ListView();
            this.Level = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Type = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.comboBox_movement = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_upgradeFlower)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_currentFlower)).BeginInit();
            this.SuspendLayout();
            // 
            // buttonGrailForm
            // 
            this.buttonGrailForm.Location = new System.Drawing.Point(12, 405);
            this.buttonGrailForm.Name = "buttonGrailForm";
            this.buttonGrailForm.Size = new System.Drawing.Size(75, 23);
            this.buttonGrailForm.TabIndex = 0;
            this.buttonGrailForm.Text = "Grails";
            this.buttonGrailForm.UseVisualStyleBackColor = true;
            this.buttonGrailForm.Click += new System.EventHandler(this.buttonGrailForm_Click);
            // 
            // label_flowerResult
            // 
            this.label_flowerResult.AutoSize = true;
            this.label_flowerResult.Location = new System.Drawing.Point(379, 35);
            this.label_flowerResult.Name = "label_flowerResult";
            this.label_flowerResult.Size = new System.Drawing.Size(0, 13);
            this.label_flowerResult.TabIndex = 22;
            // 
            // button_flowerCalc
            // 
            this.button_flowerCalc.Location = new System.Drawing.Point(12, 110);
            this.button_flowerCalc.Name = "button_flowerCalc";
            this.button_flowerCalc.Size = new System.Drawing.Size(75, 23);
            this.button_flowerCalc.TabIndex = 21;
            this.button_flowerCalc.Text = "Calculate";
            this.button_flowerCalc.UseVisualStyleBackColor = true;
            this.button_flowerCalc.Click += new System.EventHandler(this.button_flowerCalc_Click);
            // 
            // label_infantry
            // 
            this.label_infantry.AutoSize = true;
            this.label_infantry.Location = new System.Drawing.Point(12, 86);
            this.label_infantry.Name = "label_infantry";
            this.label_infantry.Size = new System.Drawing.Size(184, 13);
            this.label_infantry.TabIndex = 20;
            this.label_infantry.Text = "Is the unit a pre-Book III Infantry unit?";
            // 
            // checkBox_infantry
            // 
            this.checkBox_infantry.AutoSize = true;
            this.checkBox_infantry.Location = new System.Drawing.Point(202, 85);
            this.checkBox_infantry.Name = "checkBox_infantry";
            this.checkBox_infantry.Size = new System.Drawing.Size(120, 17);
            this.checkBox_infantry.TabIndex = 19;
            this.checkBox_infantry.Text = "Pre-Book III Infantry";
            this.checkBox_infantry.UseVisualStyleBackColor = true;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(12, 35);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(159, 13);
            this.label5.TabIndex = 16;
            this.label5.Text = "What is the current flower level?";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(12, 9);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(255, 13);
            this.label4.TabIndex = 15;
            this.label4.Text = "How many times is the Flower level being increased?";
            // 
            // numericUpDown_upgradeFlower
            // 
            this.numericUpDown_upgradeFlower.Location = new System.Drawing.Point(274, 7);
            this.numericUpDown_upgradeFlower.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.numericUpDown_upgradeFlower.Name = "numericUpDown_upgradeFlower";
            this.numericUpDown_upgradeFlower.Size = new System.Drawing.Size(43, 20);
            this.numericUpDown_upgradeFlower.TabIndex = 23;
            // 
            // numericUpDown_currentFlower
            // 
            this.numericUpDown_currentFlower.Location = new System.Drawing.Point(274, 33);
            this.numericUpDown_currentFlower.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.numericUpDown_currentFlower.Name = "numericUpDown_currentFlower";
            this.numericUpDown_currentFlower.Size = new System.Drawing.Size(43, 20);
            this.numericUpDown_currentFlower.TabIndex = 24;
            // 
            // listView1
            // 
            this.listView1.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.Level,
            this.Type});
            this.listView1.HideSelection = false;
            this.listView1.Location = new System.Drawing.Point(328, 7);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(460, 421);
            this.listView1.TabIndex = 25;
            this.listView1.UseCompatibleStateImageBehavior = false;
            this.listView1.View = System.Windows.Forms.View.Details;
            // 
            // Level
            // 
            this.Level.Text = "Level";
            // 
            // Type
            // 
            this.Type.Text = "Type";
            // 
            // comboBox_movement
            // 
            this.comboBox_movement.FormattingEnabled = true;
            this.comboBox_movement.Location = new System.Drawing.Point(197, 61);
            this.comboBox_movement.Name = "comboBox_movement";
            this.comboBox_movement.Size = new System.Drawing.Size(121, 21);
            this.comboBox_movement.TabIndex = 27;
            this.comboBox_movement.SelectedIndexChanged += new System.EventHandler(this.comboBox_movement_SelectedIndexChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 62);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(87, 13);
            this.label1.TabIndex = 28;
            this.label1.Text = "Movement Type:";
            // 
            // FlowerCalc
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBox_movement);
            this.Controls.Add(this.listView1);
            this.Controls.Add(this.numericUpDown_currentFlower);
            this.Controls.Add(this.numericUpDown_upgradeFlower);
            this.Controls.Add(this.label_flowerResult);
            this.Controls.Add(this.button_flowerCalc);
            this.Controls.Add(this.label_infantry);
            this.Controls.Add(this.checkBox_infantry);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.buttonGrailForm);
            this.Name = "FlowerCalc";
            this.Text = "FlowerCalc";
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_upgradeFlower)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_currentFlower)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button buttonGrailForm;
        private System.Windows.Forms.Label label_flowerResult;
        private System.Windows.Forms.Button button_flowerCalc;
        private System.Windows.Forms.Label label_infantry;
        private System.Windows.Forms.CheckBox checkBox_infantry;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown numericUpDown_upgradeFlower;
        private System.Windows.Forms.NumericUpDown numericUpDown_currentFlower;
        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.ColumnHeader Level;
        private System.Windows.Forms.ColumnHeader Type;
        private System.Windows.Forms.ComboBox comboBox_movement;
        private System.Windows.Forms.Label label1;
    }
}