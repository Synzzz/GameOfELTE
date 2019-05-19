namespace GameOfELTE.GUI
{
    partial class OfferedMarkWindow
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
            this.lstBox_subjects = new System.Windows.Forms.ListBox();
            this.btn_ok = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // lstBox_subjects
            // 
            this.lstBox_subjects.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_subjects.FormattingEnabled = true;
            this.lstBox_subjects.ItemHeight = 15;
            this.lstBox_subjects.Location = new System.Drawing.Point(12, 48);
            this.lstBox_subjects.Name = "lstBox_subjects";
            this.lstBox_subjects.Size = new System.Drawing.Size(288, 319);
            this.lstBox_subjects.TabIndex = 8;
            // 
            // btn_ok
            // 
            this.btn_ok.Location = new System.Drawing.Point(109, 373);
            this.btn_ok.Name = "btn_ok";
            this.btn_ok.Size = new System.Drawing.Size(90, 25);
            this.btn_ok.TabIndex = 7;
            this.btn_ok.Text = "Ok";
            this.btn_ok.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(9, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(301, 32);
            this.label1.TabIndex = 6;
            this.label1.Text = "Kiderült, hogy sikerült megajánlott jegyet szerezni,\r\negy általad választott tárg" +
    "yra.";
            this.label1.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // OfferedMarkWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(312, 409);
            this.Controls.Add(this.lstBox_subjects);
            this.Controls.Add(this.btn_ok);
            this.Controls.Add(this.label1);
            this.Name = "OfferedMarkWindow";
            this.Text = "Megajánlott jegy";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lstBox_subjects;
        private System.Windows.Forms.Button btn_ok;
        private System.Windows.Forms.Label label1;
    }
}