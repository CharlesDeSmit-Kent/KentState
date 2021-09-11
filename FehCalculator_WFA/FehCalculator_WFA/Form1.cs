using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace FehCalculator_WFA
{
    public partial class Form1 : Form
    {

       

        public Form1()
        {
            InitializeComponent();
            
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
         
        private void buttonFlowerForm_Click(object sender, EventArgs e)
        {
            FlowerCalc flower = new FlowerCalc();
            flower.Show();
            this.Hide();
        }

        private void button_grailsForm_Click(object sender, EventArgs e)
        {
            GrailsCalc grails = new GrailsCalc();
            grails.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            CodesCalc codes = new CodesCalc();
            codes.Show();
            this.Hide();
        }
    }
}
