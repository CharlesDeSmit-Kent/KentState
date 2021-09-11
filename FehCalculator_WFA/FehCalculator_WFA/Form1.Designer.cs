
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
            this.label_result = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label8 = new System.Windows.Forms.Label();
            this.button_flowerForm = new System.Windows.Forms.Button();
            this.button_grailsForm = new System.Windows.Forms.Button();
            this.button_codesForm = new System.Windows.Forms.Button();
            this.SuspendLayout();
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
            this.label3.Location = new System.Drawing.Point(12, 9);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(78, 13);
            this.label3.TabIndex = 6;
            this.label3.Text = "Grail Calculator";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(12, 38);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(88, 13);
            this.label7.TabIndex = 15;
            this.label7.Text = "Flower Calculator";
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(12, 67);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(115, 13);
            this.label8.TabIndex = 17;
            this.label8.Text = "Divine Code Calculator";
            // 
            // button_flowerForm
            // 
            this.button_flowerForm.Location = new System.Drawing.Point(153, 33);
            this.button_flowerForm.Name = "button_flowerForm";
            this.button_flowerForm.Size = new System.Drawing.Size(75, 23);
            this.button_flowerForm.TabIndex = 31;
            this.button_flowerForm.Text = "Flowers";
            this.button_flowerForm.UseVisualStyleBackColor = true;
            this.button_flowerForm.Click += new System.EventHandler(this.buttonFlowerForm_Click);
            // 
            // button_grailsForm
            // 
            this.button_grailsForm.Location = new System.Drawing.Point(153, 4);
            this.button_grailsForm.Name = "button_grailsForm";
            this.button_grailsForm.Size = new System.Drawing.Size(75, 23);
            this.button_grailsForm.TabIndex = 32;
            this.button_grailsForm.Text = "Grails";
            this.button_grailsForm.UseVisualStyleBackColor = true;
            this.button_grailsForm.Click += new System.EventHandler(this.button_grailsForm_Click);
            // 
            // button_codesForm
            // 
            this.button_codesForm.Location = new System.Drawing.Point(153, 62);
            this.button_codesForm.Name = "button_codesForm";
            this.button_codesForm.Size = new System.Drawing.Size(75, 23);
            this.button_codesForm.TabIndex = 33;
            this.button_codesForm.Text = "Codes";
            this.button_codesForm.UseVisualStyleBackColor = true;
            this.button_codesForm.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button_codesForm);
            this.Controls.Add(this.button_grailsForm);
            this.Controls.Add(this.button_flowerForm);
            this.Controls.Add(this.label8);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label_result);
            this.Name = "Form1";
            this.Text = "Feh Calculator";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label_result;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Button button_flowerForm;
        private System.Windows.Forms.Button button_grailsForm;
        private System.Windows.Forms.Button button_codesForm;
    }
}

