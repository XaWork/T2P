// Generated by Dagger (https://dagger.dev).
package me.taste2plate.app.customer.repo;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.storage.StorageReference;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class FirebaseUserRepository_Factory implements Factory<FirebaseUserRepository> {
  private final Provider<CollectionReference> usersProvider;

  private final Provider<StorageReference> storageProvider;

  public FirebaseUserRepository_Factory(Provider<CollectionReference> usersProvider,
      Provider<StorageReference> storageProvider) {
    this.usersProvider = usersProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public FirebaseUserRepository get() {
    return newInstance(usersProvider.get(), storageProvider.get());
  }

  public static FirebaseUserRepository_Factory create(Provider<CollectionReference> usersProvider,
      Provider<StorageReference> storageProvider) {
    return new FirebaseUserRepository_Factory(usersProvider, storageProvider);
  }

  public static FirebaseUserRepository newInstance(CollectionReference users,
      StorageReference storage) {
    return new FirebaseUserRepository(users, storage);
  }
}
