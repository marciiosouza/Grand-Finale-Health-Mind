using apiHealthMind.Context;
using apiHealthMind.Model;
using System.ComponentModel.DataAnnotations;

namespace apiHealthMind.Repository
{
    public class UsuarioRepository
    {
        private readonly AppDbContext dataBaseContext;

        public UsuarioRepository(AppDbContext dbx)
        {
            dataBaseContext = dbx;
        }

        public void InserirUsuario(UsuarioModel usuario)
        {
            dataBaseContext.usuario.Add(usuario);
            dataBaseContext.SaveChanges();
        }

        public UsuarioModel buscaUsuario(String email , String senha)
        {
            var usuario = dataBaseContext.usuario.SingleOrDefault(i => i.email == email && i.senha == senha);
            return usuario;
        }
    }
}
