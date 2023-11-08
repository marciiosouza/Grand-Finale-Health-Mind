using apiHealthMind.Context;
using apiHealthMind.Model;

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
    }
}
