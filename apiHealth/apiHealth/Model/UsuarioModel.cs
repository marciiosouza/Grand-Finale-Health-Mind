using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace apiHealth.Model
{
    
    [Table("Tb_Usuarios")]
    public class UsuarioModel
    {
        [Key]
        public int UsuarioId { get; set; }
        public string nome { get; set; }
        public string email { get; set; }
        public string senha { get; set; }

        
    }
}
