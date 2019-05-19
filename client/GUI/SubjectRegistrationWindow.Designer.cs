namespace GameOfELTE.GUI
{
    partial class SubjectRegistrationWindow
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.btn_enroll = new System.Windows.Forms.Button();
            this.btn_abandon = new System.Windows.Forms.Button();
            this.lstBox_picked = new System.Windows.Forms.ListBox();
            this.btn_finalize = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lstBox_subjects
            // 
            this.lstBox_subjects.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_subjects.FormattingEnabled = true;
            this.lstBox_subjects.ItemHeight = 16;
            this.lstBox_subjects.Location = new System.Drawing.Point(16, 32);
            this.lstBox_subjects.Name = "lstBox_subjects";
            this.lstBox_subjects.Size = new System.Drawing.Size(260, 260);
            this.lstBox_subjects.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(360, 13);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(111, 16);
            this.label1.TabIndex = 2;
            this.label1.Text = "Felvett tárgyak";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(13, 13);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(66, 16);
            this.label2.TabIndex = 2;
            this.label2.Text = "Tárgyak";
            // 
            // btn_enroll
            // 
            this.btn_enroll.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_enroll.Location = new System.Drawing.Point(282, 143);
            this.btn_enroll.Name = "btn_enroll";
            this.btn_enroll.Size = new System.Drawing.Size(75, 23);
            this.btn_enroll.TabIndex = 3;
            this.btn_enroll.Text = "Felvétel";
            this.btn_enroll.UseVisualStyleBackColor = true;
            // 
            // btn_abandon
            // 
            this.btn_abandon.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_abandon.Location = new System.Drawing.Point(282, 172);
            this.btn_abandon.Name = "btn_abandon";
            this.btn_abandon.Size = new System.Drawing.Size(75, 23);
            this.btn_abandon.TabIndex = 3;
            this.btn_abandon.Text = "Leadás";
            this.btn_abandon.UseVisualStyleBackColor = true;
            // 
            // lstBox_picked
            // 
            this.lstBox_picked.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lstBox_picked.FormattingEnabled = true;
            this.lstBox_picked.ItemHeight = 16;
            this.lstBox_picked.Location = new System.Drawing.Point(363, 32);
            this.lstBox_picked.Name = "lstBox_picked";
            this.lstBox_picked.Size = new System.Drawing.Size(260, 260);
            this.lstBox_picked.TabIndex = 0;
            // 
            // btn_finalize
            // 
            this.btn_finalize.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_finalize.Location = new System.Drawing.Point(266, 298);
            this.btn_finalize.Name = "btn_finalize";
            this.btn_finalize.Size = new System.Drawing.Size(104, 30);
            this.btn_finalize.TabIndex = 3;
            this.btn_finalize.Text = "Véglegesítés";
            this.btn_finalize.UseVisualStyleBackColor = true;
            // 
            // SubjectRegistrationWindow
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(636, 340);
            this.Controls.Add(this.btn_finalize);
            this.Controls.Add(this.btn_abandon);
            this.Controls.Add(this.btn_enroll);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lstBox_picked);
            this.Controls.Add(this.lstBox_subjects);
            this.Name = "SubjectRegistrationWindow";
            this.Text = "Tárgyfelvétel";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ListBox lstBox_subjects;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btn_enroll;
        private System.Windows.Forms.Button btn_abandon;
        private System.Windows.Forms.ListBox lstBox_picked;
        private System.Windows.Forms.Button btn_finalize;
    }
}