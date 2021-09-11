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
    public partial class CodesCalc : Form
    {
        public CodesCalc()
        {
            InitializeComponent();
        }

        private void button_codesCalc_Click(object sender, EventArgs e)
        {
            List<NumericUpDown> codesList = new List<NumericUpDown>();
            codesList.Add(upDown_tier1);
            codesList.Add(upDown_tier2);
            codesList.Add(upDown_tier3);
            codesList.Add(upDown_tier4);
            codesList.Add(upDown_tier5);
            int totalCodes = 0;
            int counter = 1;
            foreach (NumericUpDown a in codesList)
            {
                totalCodes += Convert.ToInt32(a.Value) * (400 * counter);
                ++counter;
            }
            label_codesResult.Text = "The total cost is " + totalCodes + " Codes";
        }
    }
}
