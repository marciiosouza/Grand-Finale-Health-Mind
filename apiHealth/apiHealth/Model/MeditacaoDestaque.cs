using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace apiHealth.Model
{
    [Table("Tb_MeditacaoDestaque")]
    public class MeditacaoDestaque
    {  
        
        public int MeditacaoId { get; set; }

        [JsonIgnore]
        public MeditacaoModel? meditacao { get; set; }
        
        public int UsuarioId { get; set; }
        [JsonIgnore]
        public UsuarioModel? usuario { get; set; }


        public DateTime DataAcesso { get; set; }
        
       

    }
}
