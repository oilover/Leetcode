        static string printable = "";
        static Random rnd = new Random();
        public static string RandStr()  /// Generate random string
        {
            return RandStr(rnd.Next(100) + 100);
        }
        public static string RandStr(int len)
        {
            StringBuilder sb = new StringBuilder();
            if (printable == "")
            {
                for (char ch = (char)0; ch < (char)127; ch++) if (Char.IsLetterOrDigit(ch)) sb.Append(ch);
                printable = sb.ToString();
            }
            sb.Clear();

            for (int j = 0; j < len; j++)
            {
                int pos = rnd.Next(printable.Length);
                sb.Append(printable[pos]);
                if (j % 100 == 99) sb.Append('\n');
            }
            return sb.ToString();
        }
