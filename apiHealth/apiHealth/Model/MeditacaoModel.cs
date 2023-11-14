using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace apiHealth.Model
{
    [Table("tb_Meditacoes")]
    public class MeditacaoModel
    {
        [Key]
        public int MeditacaoId { get; set; }

        public String Titulo { get; set; }
        public String CaminhoArquivo { get; set; }
    }
}
