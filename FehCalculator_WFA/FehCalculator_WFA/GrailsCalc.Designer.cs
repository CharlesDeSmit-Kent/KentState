
namespace FehCalculator_WFA
{
    partial class GrailsCalc
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
            this.comboBox_Grail = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.button_GrailCalc = new System.Windows.Forms.Button();
            this.label3 = new System.Windows.Forms.Label();
            this.listView_grailList = new System.Windows.Forms.ListView();
            this.Unit = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Grails = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.Feathers = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.label4 = new System.Windows.Forms.Label();
            this.numericUpDown_grailsBuying = new System.Windows.Forms.NumericUpDown();
            this.numericUpDown_grailsBought = new System.Windows.Forms.NumericUpDown();
            this.label_grailResult = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_grailsBuying)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_grailsBought)).BeginInit();
            this.SuspendLayout();
            // 
            // comboBox_Grail
            // 
            this.comboBox_Grail.FormattingEnabled = true;
            this.comboBox_Grail.Location = new System.Drawing.Point(256, 54);
            this.comboBox_Grail.Name = "comboBox_Grail";
            this.comboBox_Grail.Size = new System.Drawing.Size(121, 21);
            this.comboBox_Grail.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(12, 55);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(152, 13);
            this.label1.TabIndex = 1;
            this.label1.Text = "What unit are you purchasing?";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(12, 81);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(218, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "How many copies are you buying with grails?";
            // 
            // button_GrailCalc
            // 
            this.button_GrailCalc.Location = new System.Drawing.Point(257, 131);
            this.button_GrailCalc.Name = "button_GrailCalc";
            this.button_GrailCalc.Size = new System.Drawing.Size(75, 23);
            this.button_GrailCalc.TabIndex = 0;
            this.button_GrailCalc.Text = "Add";
            this.button_GrailCalc.UseVisualStyleBackColor = true;
            this.button_GrailCalc.Click += new System.EventHandler(this.button_GrailCalc_Click);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(12, 107);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(217, 13);
            this.label3.TabIndex = 4;
            this.label3.Text = "How many copies have you already bought?";
            // 
            // listView_grailList
            // 
            this.listView_grailList.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.Unit,
            this.Grails,
            this.Feathers});
            this.listView_grailList.HideSelection = false;
            this.listView_grailList.Location = new System.Drawing.Point(384, 52);
            this.listView_grailList.Name = "listView_grailList";
            this.listView_grailList.Size = new System.Drawing.Size(404, 362);
            this.listView_grailList.TabIndex = 30;
            this.listView_grailList.UseCompatibleStateImageBehavior = false;
            this.listView_grailList.View = System.Windows.Forms.View.Details;
            // 
            // Unit
            // 
            this.Unit.Text = "Unit";
            this.Unit.Width = 200;
            // 
            // Grails
            // 
            this.Grails.Text = "Grails";
            this.Grails.Width = 100;
            // 
            // Feathers
            // 
            this.Feathers.Text = "Feathers";
            this.Feathers.Width = 100;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(340, 9);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(78, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Grail Calculator";
            // 
            // numericUpDown_grailsBuying
            // 
            this.numericUpDown_grailsBuying.Location = new System.Drawing.Point(257, 79);
            this.numericUpDown_grailsBuying.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.numericUpDown_grailsBuying.Name = "numericUpDown_grailsBuying";
            this.numericUpDown_grailsBuying.Size = new System.Drawing.Size(120, 20);
            this.numericUpDown_grailsBuying.TabIndex = 31;
            // 
            // numericUpDown_grailsBought
            // 
            this.numericUpDown_grailsBought.Location = new System.Drawing.Point(257, 105);
            this.numericUpDown_grailsBought.Maximum = new decimal(new int[] {
            20,
            0,
            0,
            0});
            this.numericUpDown_grailsBought.Name = "numericUpDown_grailsBought";
            this.numericUpDown_grailsBought.Size = new System.Drawing.Size(120, 20);
            this.numericUpDown_grailsBought.TabIndex = 32;
            // 
            // label_grailResult
            // 
            this.label_grailResult.AutoSize = true;
            this.label_grailResult.Location = new System.Drawing.Point(383, 428);
            this.label_grailResult.Name = "label_grailResult";
            this.label_grailResult.Size = new System.Drawing.Size(35, 13);
            this.label_grailResult.TabIndex = 33;
            this.label_grailResult.Text = "label5";
            // 
            // GrailsCalc
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.label_grailResult);
            this.Controls.Add(this.numericUpDown_grailsBought);
            this.Controls.Add(this.numericUpDown_grailsBuying);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.comboBox_Grail);
            this.Controls.Add(this.listView_grailList);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.button_GrailCalc);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label4);
            this.Name = "GrailsCalc";
            this.Text = "GrailsCalc";
            this.Load += new System.EventHandler(this.GrailsCalc_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_grailsBuying)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown_grailsBought)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBox_Grail;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button_GrailCalc;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ListView listView_grailList;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.NumericUpDown numericUpDown_grailsBuying;
        private System.Windows.Forms.NumericUpDown numericUpDown_grailsBought;
        private System.Windows.Forms.Label label_grailResult;
        private System.Windows.Forms.ColumnHeader Unit;
        private System.Windows.Forms.ColumnHeader Grails;
        private System.Windows.Forms.ColumnHeader Feathers;
    }
}